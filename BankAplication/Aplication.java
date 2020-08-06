import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aplication {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Dobrodosli.\n Molimo unesite");
		System.out.println("0 za kreiranje racuna");
		System.out.println("1 za prebacivanje novca");
		System.out.println("2 za ispisivanje racuna");
		int user=input.nextInt();
				
		switch(user) {
		case 0:
			System.out.print("Broj racuna: ");
			int account=input.nextInt();
			System.out.print("\nIme klijenta: ");
			String name=input.next();
			System.out.print("Iznos novca: ");
			double cash=input.nextDouble();
			Client cl=new Client(account,name,cash);
			break;
		case 1:
			System.out.print("Broj racuna sa kojeg se novac prebacuje: ");
			int source=input.nextInt();
			System.out.print("\nBroj racuna na koji se novac prebacuje: ");
			int target=input.nextInt();
			System.out.println("\nIznos koji se prebacuje: ");
			double money=input.nextDouble();
			Client client=new Client();
			client.transfer(source, target, money);
			break;
		case 2:
			//Client clientPrint=new Client();
			Client.listClients();
			break;
		default:
			System.out.println("Pogresan unos");
			break;
		}
		input.close();
	}

}
