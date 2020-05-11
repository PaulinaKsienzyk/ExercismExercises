class Twofer {

    String twofer(String name) {
         String nameOrYou = (name == null) ? "you" : name;
        return "One for " + nameOrYou + ", one for me.";
    }
}
