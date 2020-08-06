# TransferNovca

Napisati jednostavnu bankovnu aplikaciju.
Aplikacija treba da nudi sledeće usluge:
●	Kreiranje računa
●	Prebacivanje novca sa jednog računa na drugi
●	Ispisivanje detalja postojećih računa

Kreiranje računa
Kada kreirate račun, uzimate sljedeće parametre: 
●	Broj računa (int)
●	Ime vlasnika računa (String)
●	Iznos na računu (double)
Validacija:
●	Ne smijete dozvoliti kreiranje  više računa sa istim brojem
●	Ne smijete dozvoliti kreiranje računa sa negativnim brojem
●	Ne smijete dozvoliti kreiranje računa sa negativnim iznosom na računu

Transfer novca
Prilikom transfera novca uzimate sledeće parametre:
●	Broj računa sa koga se prebacuje novac – source account (int)
●	Broj računa na koji se prebacuje novac – target account (int)
●	Iznos koji se prebacuje (double)
Sa validnim parametrima, aplikacija bi trebala da na target account doda iznos koji se prebacuje, a da sa source accounta oduzme isti iznos.
Validacija:
●	Ne smijete dozvoliti transfer ako na source accountu nema dovoljno novca
●	Ne smijete dozvoliti transfer ukoliko je broj source računa nevažeći / ne postoji source račun u sistemu
●	Ne smijete dozvoliti transfer ukoliko je broj target računa nevažeći / ne postoji target račun u sistemu



