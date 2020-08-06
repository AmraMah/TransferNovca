import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class Client {

	private int account;
	private String name;
	private double money;
	public static String filepath="clients.txt";
	public File filex=new File(filepath);
	public Client() {
		
	}
	
	public Client(int account, String name, double money) {
		if(account<=0 || money<0) {
			System.out.println("Broj racuna mora biti veci od 0, iznos ne moze biti negativan.");
		}
		else {
			try {
				if(!(filex.exists()&&filex.isDirectory())){
					filex.createNewFile();
				}
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter pw=new PrintWriter(bw);
				Scanner scan=new Scanner(new File(filepath));
				scan.useDelimiter("[,\n]");
				
				//provjera da li postoji racun s istim brojem
				int x;
				boolean existing=false;
				while(scan.hasNext()) {
					x=scan.nextInt();
					scan.next();
					scan.next();
					if(x==account) {
						existing=true;
						System.out.println("Racun s tim brojem vec postoji.");
						break;
					}
				}
				if(!existing) {
					this.account=account;
					this.name=name;
					this.money=money;
					pw.println(account+","+name+","+money);
				}
					scan.close();
					pw.flush();
					pw.close();
				
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		
	public void transfer(int source, int target, double money) {
			try {
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter pw=new PrintWriter(bw);
				Scanner scan=new Scanner(new File(filepath));
				scan.useDelimiter("[,\n]");
				
				//provjera da li postoji racun s istim brojem
				int x;
				boolean sourceExist=false;
				boolean targetExist=false;
				while(scan.hasNext()) {
					x=scan.nextInt();
					if(x==source) {
						sourceExist=true;
					}
					else if(x==target) {
						targetExist=true;
					}
					scan.next();
					scan.next();
				}
				if(!sourceExist || !targetExist) {
					System.out.println("Unijeli ste nevazeci broj racuna.");
				}
				else {
					
					int s;
					boolean available=true;
					double srcCash;
					while (scan.hasNext()) {
						s=scan.nextInt();
						if(s==source) {
							scan.next();
							srcCash=scan.nextDouble();
							if(srcCash<money) {
								available=false;
								System.out.println("Nema dovoljno sredstava na racunu");
							}
						}
					}
				}				
				
				//sad izmjena fajla...
				File changedFile= changeAmount(filepath, source,target,money);
			//	System.out.println(filex.getAbsolutePath());
				
				
				scan.close();
				pw.flush();
				pw.close();
				filex.delete();
				File f=new File(filepath);
				changedFile.renameTo(f);
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
	public static File changeAmount (String filepath, int src, int target, double amount) {
		String tempFile="temp.txt";
		File oldFile= new File(filepath);
		File newFile=new File(tempFile);
		int id;
		String name;
		double cash;
		Scanner scan;
		String s="";
		try {
			FileWriter fw=new FileWriter(tempFile, true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			scan=new Scanner(new File(filepath));
			scan.useDelimiter("[,\n]");
			
			while(scan.hasNext()) {
				id=scan.nextInt();
				name=scan.next();
				s=scan.next();
				cash=Double.parseDouble(s);
				//cash=scan.nextDouble(); problem citanja nakon next() kod Scanner klase...delimiter
				if(id==src) {
					double newAmount=cash-amount;
					pw.println(id+","+name+","+newAmount);
				}
				else if(id==target) {
					double newAmount=cash+amount;
					pw.println(id+","+name+","+newAmount);
				}
				else {
					pw.println(id+","+name+","+cash);
				}
			}
			scan.close();
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFile;
	}
	
	public static void listClients() throws FileNotFoundException {
		Scanner scan=new Scanner(new File(filepath));
		scan.useDelimiter("[,\n]");
		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}
		scan.close();
	}
	
}
