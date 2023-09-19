package phonebook;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Phonebook yellowPages = new Phonebook();
        ArrayList<String> s = new ArrayList<>();
        s.add("302-888-9231");
        yellowPages.add("Caitlyn Franks", s);
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("302-888-9232");
        yellowPages.add("Mark Franks", s1);
        ArrayList<String> s2 = new ArrayList<>();
        s2.add("521-838-9531");
        s2.add("394-284-2939");
        yellowPages.add("Chance Marks", s2);
        String[] s3={"394-289-2932", "646-392-1111"};
        System.out.println(yellowPages.getAllContactNames());
        System.out.println("After Remove : ");
        System.out.println(yellowPages.getAllContactNames());
        String[] moreNums={"392-111-1231", "293-111-4921"};
        yellowPages.addAll("Caitlyn Franks", moreNums );
        System.out.println(yellowPages.toString());
        System.out.print("The number '395-284-2939' belongs to "+yellowPages.reverseLookUp("394-284-2939"));


    }
}
