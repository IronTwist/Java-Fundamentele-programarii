import java.util.*;

public class Aplicatie1 {

	public static void afisNatural(String s, Natural A){
		System.out.println(s+A.getN());
	}
	
	public static void Bule(Natural[]Y){
        boolean flag;				 // sortarea vectorului
		int i,aux,poz,pozInter;
		poz    = pozInter = Y.length-2;  
		do
		 { flag=true;
		   for (i=0;i<=poz;i++)
		     if ( !(Y[i].maiMic(Y[i+1])) )
						{ aux    = Y[i].getN();			//schimb Y[i]<->Y[i+1]
						  Y[i].setN(Y[i+1].getN());			
						  Y[i+1].setN(aux);				
						  pozInter = i;
						  flag     = false;
						}
			  poz=pozInter;
			}
		  while (!flag);
		}

	
	public static void main(String[] args) {
		Natural X= new Natural();   afisNatural("X=",X);		//X are n=0
		Natural A= new Natural(7); 	afisNatural("A=",A);
		Natural B= new Natural(4);  afisNatural("B=",B);
		Natural C= new Natural(-5); afisNatural("C=",C);
		Natural D= new Natural(A);  afisNatural("D=",D);	    //utilizare constr. copiere
		C.setN(100);				afisNatural("C=",C);
		if(A.Egal(D)) System.out.println("A este egal cu D");
		else          System.out.println("A nu este egal cu D"); 
		if(A.Egal(B)) System.out.println("A este egal cu B");
		else          System.out.println("A nu este egal cu B"); 
		if(A.maiMic(D)) System.out.println("A < D");
		else            System.out.println("A >=D"); 
		if(B.maiMic(A)) System.out.println("B < A");
		else            System.out.println("B >=A"); 
		C.Plus(A);    afisNatural("C=",C);
		C.Plus(A,B);  afisNatural("C=",C);
		C.PlusPlus(5);afisNatural("C=",C);
		C=Natural.Aduna(A,B);afisNatural("C=",C);
		C.Minus(A);    afisNatural("C=",C);
		C.Minus(A,B);  afisNatural("C=",C);
		C=Natural.Scade(A,B);afisNatural("C=",C);
		C.Ori(A);      afisNatural("C=",C);
		C=Natural.Produs(A,B); afisNatural("C=",C);
		C.Slash(A);      afisNatural("C=",C);
		C=Natural.Imparte(A,B); afisNatural("C=",C);
		C.Modulo(A);      afisNatural("C=",C);
		C=Natural.Moduloo(A,B); afisNatural("C=",C);
		
		Natural [] Y= new Natural[10];  //se de declara tablou de 10, in heap se pun 
										//10 referinte Y[0],...,Y[9]
		
		for(int i=0;i<Y.length;i++)
			{Y[i]=new Natural(10-i);	//instantiere fiecarei referinte cu un Natural
			 //Y[i].setN(10-i);
			}
		System.out.println("tabloul initial:");
		for (int i=0;i<Y.length;i++)
			System.out.print(Y[i].getN()+" ");
		
		Bule(Y);
		System.out.println("\ntabloul sortat:");
		for (int i=0;i<Y.length;i++)
			System.out.print(Y[i].getN()+" ");
	}  

}
