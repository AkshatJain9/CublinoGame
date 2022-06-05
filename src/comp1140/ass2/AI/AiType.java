package comp1140.ass2.AI;

public enum AiType {
    GREEDY("Greedy"),
    MCTS("Monte Carlo Tree Search"),
    MINIMAX("Minimax"),
    RANDOM("Random"),
    ;

    String name;

    AiType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

