package phonebook;
import java.util.*;

public class Phonebook {
    HashMap<String, ArrayList<String>> phoneBook;
    public Phonebook (HashMap<String, ArrayList<String>> existingPhoneBook){
        this.phoneBook=existingPhoneBook;
    }
    public Phonebook (){
        phoneBook=new HashMap<>();
    }
    public void add(String name, ArrayList<String> phoneNumber){
        if(phoneBook.containsKey(name)){
            System.out.println("Name is already contained\n Do you want to add "+phoneNumber+ " To the list?\nY for yes, Anything else for no");
            Scanner answer;
            answer=new Scanner(System.in);
            String confirm=answer.nextLine();
            confirm.toLowerCase();
            if(confirm.equals("y")){
                phoneBook.get(name).addAll(phoneNumber);
            }
        }else{
            System.out.println(phoneNumber);
            phoneBook.put(name, phoneNumber);
        }
    }
    public void addAll(String name, ArrayList<String> phoneNumbers){
        ArrayList<String> newPhoneList= new ArrayList<>();
        if(hasEntry(name)){
            newPhoneList=phoneBook.get(name);
            phoneBook.remove(name);
        }
        newPhoneList.addAll(phoneNumbers);
        phoneBook.put(name, phoneNumbers);
    }
    public void addAll(String name, String[] phoneNumbers){
        ArrayList<String> newPhoneList= new ArrayList<>();
        if(hasEntry(name)){
            newPhoneList.add(String.valueOf(phoneBook.get(name)));
            phoneBook.remove(name);
        }
        for(String number:phoneNumbers){
            if(number!=null){
                newPhoneList.add(number);
            }
        }
        phoneBook.put(name,newPhoneList);
    }

    public void remove(String name){
        phoneBook.remove(name);
    }
    public Boolean hasEntry(String name){
        return phoneBook.containsKey(name);
    }
    public ArrayList<String> lookUp(String name){
        return phoneBook.get(name);
    }
    public String reverseLookUp(String phoneNumber){
        for(String key: phoneBook.keySet()){
            for(String compare : phoneBook.get(key)){
                if(compare.equals(phoneNumber)){
                    return key;
                }
            }
        }
        return "The phone number : "+phoneNumber+ " isn't in this phonebook";
    }
    public String getAllContactNames(){
        StringBuilder contactNames= new StringBuilder();
        for(String s : phoneBook.keySet()){
            contactNames.append(s).append("\n");
        }
        return contactNames.toString();
    }


    @Override
    public String toString(){
        StringBuilder fullPhoneBook=new StringBuilder();
        for(String key : phoneBook.keySet()){
            fullPhoneBook.append(key).append(" numbers are :");
            for(String numbers:phoneBook.get(key)){
                fullPhoneBook.append("  ").append(numbers);
            }
            fullPhoneBook.append("\n");
        }
        return fullPhoneBook.toString();
    }

}
