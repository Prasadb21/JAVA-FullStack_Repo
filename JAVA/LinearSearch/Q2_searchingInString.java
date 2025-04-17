public class Q2_searchingInString {

    public static void main(String[] args) {
        String string = "Prasad Bhalkikar";
        char targetChar = 'a';

        System.out.println(searchString(string, targetChar));
        System.out.println(searchString2(string, targetChar));
        
    }

    static boolean searchString(String str, char target)
    {
        if(str.length() == 0)
        {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if(target == str.charAt(i))
            {
                return true;
            }
        }

        return false;
    }

    static int searchString2(String str, char target)
    {
        if(str.length() == 0)
        {
            return -1;
        }

        for (char ch : str.toCharArray()) {
            if(target == ch)
            {
               return ch;
            }
        }

        return -1;
    }

    
}
