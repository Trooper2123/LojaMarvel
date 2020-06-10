package com.company;

import java.util.Scanner;

public class Client {
    public String name;
    public  String bday;
    protected  int cpf;
    public String email;
    public String phone;
    public String cep;
    char ans;

    Scanner input;
    private static int total;

    public Client () {

        this.input = new Scanner(System.in);


        System.out.println("Choose operation: \n"
                + "C - Create new Client \n"
                + "R - Look for a client \n"
                + "U - Update Cliente \n"
                + "D - Delet Client\n"
        );

        this.ans = input.next().toUpperCase().charAt(0);

        this.choosedOperation(ans);

    }

    public void choosedOperation(char ans){
        switch (ans) {
            case 'C': this.create();
            break;
            case 'R' : this.look();
            break;
            case 'U' : this.update();
            break;
            case 'D': this.deleteCient();
            break;
            default:
                System.out.println(" NOT A VALID OPTION");
            }
        }

        public void create (){
            System.out.println("Insert your name: ");
            this.name = input.next();
            System.out.println("Insert your phone: ");
            this.phone = input.next();
            System.out.println("Insert your bday: ");
            this.bday = input.next();
            System.out.println("Insert your CPF");// implement mask
            this.cpf = input.nextInt();
            System.out.println("Insert your best e-mail: ");
            this.email = input.next();
            System.out.println("Insert your CEP: ");
            this.cep = input.next();

           this.prinInfo();

           Client.total ++;

    }

    public void look() {
        System.out.println("One client (o) or (a) for all clients: ");
        this.ans = input.next().toUpperCase().charAt(0);
        if (ans == 'A') {
            this.lookAll();
        } else if (ans == 'O') {
            System.out.println("Insert CPF: ");
            this.cpf = input.nextInt();
            this.prinInfoClient(cpf);
        } else {
            System.out.println("Not a valid option");
        }
    }

    public void lookAll(){

        for(int i = 0; i < Client.total ; i++){
            this.prinInfo();
        }
    }

    public void deleteCient(){
        System.out.println("Insert CPF: ");
        this.cpf = input.nextInt();
        System.out.println("Wish to delete permanently this user ? y/n " + this.name +" "+ this.cpf );
        this.ans = input.next().charAt(0);
        if(ans== 'y'){
            Client.total --;
            System.out.println("Delete operation succeed");
            //incluir ação de deletar
        }else {
            System.out.println("Delete operation terminated");
        }

    }

    public void update(){
        System.out.println("Insert CPF: ");
        this.cpf = input.nextInt();
        prinInfoClient(cpf);
        System.out.println("Choose info to update:");
        System.out.println("N - Name \n"
            +"B - Bday\n"
            +"E - e-mail\n"
            +"P - Phone\n"
            +"C - CEP\n");
        this.ans = input.next().toUpperCase().charAt(0);

        switch (ans) {
            case 'N': setName();
            break;
            case 'B' : setBday();
            break;
            case 'E': setEmail();
            break;
            case 'P' : setPhone();
            break;
            case 'C' : setCEP();
            break;
            default:
                System.out.println("Not a valid operation");
        }
    }

    public void prinInfo(){
        System.out.println("User Name: "+ this.name);
        System.out.println("User Bday: "+ this.bday);
        System.out.println("User CPF: " + this.cpf);
        System.out.println("User e-mail: "+ this.email);
        System.out.println("USER CEP: "+ this.cep);
        System.out.println("USER CEP: "+ this.phone);
    }

    public void prinInfoClient(int cpf){
        System.out.println("User Name: "+ this.name);
        System.out.println("User Bday: "+ this.bday);
        System.out.println("User e-mail: "+ this.email);
        System.out.println("USER CEP: "+ this.cep);
        System.out.println("USER Phone: "+ this.phone);
    }

    public void setName(){
        System.out.println("Insert new name: ");
        this.name = input.next();
        prinInfo();
    }

    public void setEmail(){
        System.out.println("Insert new email: ");
        this.email = input.next();
        prinInfo();
    }

    public void setPhone(){
        System.out.println("Insert new phone: ");
        this.phone = input.next();
        prinInfo();
    }

    public void setCEP(){
        System.out.println("Insert new CEP: ");
        this.cep = input.next();
        prinInfo();
    }
    public void setBday(){
        System.out.println("Insert new Bday: ");
        this.bday = input.next();
        prinInfo();
    }
}
