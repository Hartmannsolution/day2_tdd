public class ClassForTest {
    public String methodForTest(Object o) {
        if (o == null)
            return "Hello, My Friend.";
        if (o instanceof String)
            return "Hello " + o + ".";
        if (o instanceof String[]) { // if array of strings
            String[] stringArray = (String[]) o;
//            if (oa.length == 2) // simply inject 'and'
//                return "Hello " + oa[0] + " and " + oa[1];
            if (stringArray.length == 1)
                return "Hello " + stringArray[0] + ".";

            String result = "Hello ";
            String shouting = "HELLO ";
            int stopIndex = stringArray.length;
            for (int i = 0; i < stopIndex; i++) {
                String name = stringArray[i];
                if(name.contains("\"")) // if name contains quotes remove them and keep the comma
                    name = name.replace("\"", "");

                else if(name.contains(",")) {// if comma in string extend our collection with names from comma separated string
                    stringArray = addNames(stringArray, name);
                    stopIndex += name.split(",").length;
                    continue;
                }
                if(name.equals(name.toUpperCase())) // if shouting
                    shouting = getGreeting(name, shouting, shouting.length() == 6, i == stringArray.length - 1);
                else
                    result = getGreeting(name, result, result.length() == 6, i == stringArray.length - 1);
            }
            return (shouting.length() > 6)? result + ". AND " + shouting + "!": result+".";
        }
        return null;
    }

    private String getGreeting(String name, String greeting, boolean isFirstName, boolean isLastName) {
        if(isFirstName)
            return greeting + name;
        if(isLastName)
            return greeting +" and " + name;
        return greeting + ", "+ name; // It is neither first nor last name
    }
    // add names from comma separated string to string array

    private String[] addNames(String[] stringArray, String commaSeparatedString) {
        // split comma separated string and add them into array of names
        String[] names = commaSeparatedString.split(",");
        String[] result = new String[stringArray.length + names.length];
        // fill new array with old values first
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = stringArray[i];
        }
        // add new names from comma separated string
        for (int i = 0; i < names.length; i++) {
            result[i + stringArray.length] = names[i];
        }
        return result;
    }
}
