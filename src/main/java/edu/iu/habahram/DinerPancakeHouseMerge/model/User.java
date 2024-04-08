package edu.iu.habahram.DinerPancakeHouseMerge.model;



public record User(String email, String username, String password) {
    public String toLine() {

        return String.format("%1$s,%2$s,%3$s", email, username, password);
    }
    public static User fromLine(String line) {
        String[] tokens = line.split(",");
        return new User(tokens[0], tokens[1], tokens[2]);
    }
}
