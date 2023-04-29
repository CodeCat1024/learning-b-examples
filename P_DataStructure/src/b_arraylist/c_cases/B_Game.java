package b_arraylist.c_cases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生成 54 张牌，然后进行洗牌
 */
class Poker {
    private String suit; // 花色
    private int rank; // 数字

    public Poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{" + suit + " " + rank + "}";
    }
}

public class B_Game {
    private static final String[] suits = {"❤", "♣", "♦", "♠"};

    // 生成54张牌
    public List<Poker> buyPoker() {
        List<Poker> pokers = new ArrayList<>();

        for (int i = 0; i < 4; i ++) {
            for (int j = 1; j <= 13; j++) {
                Poker poker = new Poker(suits[i], j);
                pokers.add(poker);
            }
        }

        return pokers;
    }

    public void shuffle(List<Poker> pokers) {
        for (int i = pokers.size() - 1; i > 0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(pokers, i, index);
        }
    }

    private void swap(List<Poker> pokers, int i, int j) {
        Poker tmp = pokers.get(i);
        pokers.set(i, pokers.get(j));
        pokers.set(j, tmp);
    }

    public List<List<Poker>> game(List<Poker> pokers) {

        List<List<Poker>> hand = new ArrayList<>();

        List<Poker> hand1 = new ArrayList<>();
        List<Poker> hand2 = new ArrayList<>();
        List<Poker> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        // 最外层循环 控制 轮数
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                Poker removePoker = pokers.remove(0);
                hand.get(j).add(removePoker);
            }
        }

        return hand;
    }

    public static void main(String[] args) {

        B_Game game = new B_Game();
        List<Poker> pokers = game.buyPoker();

        System.out.println("洗牌前：");
        System.out.println(pokers);

        game.shuffle(pokers);
        System.out.println("洗牌后：");
        System.out.println(pokers);

        List<List<Poker>> hand = game.game(pokers);
        System.out.println("揭牌后：");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("第 " + (i + 1) + "个人的牌为："+ hand.get(i));
        }

        System.out.println("剩下的牌为：");
        System.out.println(pokers);
    }
}


