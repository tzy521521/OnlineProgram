package WangXiHU;

import java.util.*;

/**
 * 游戏
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                int protagonist_Blood=scanner.nextInt();
                int protagonist_Atk=scanner.nextInt();
                int CD=scanner.nextInt();
                ArrayList<Abilitie> abilities=new ArrayList<>();
                for (int j = 0; j <3 ; j++) {
                    int protagonist_Abilitie_Atk=scanner.nextInt();
                    abilities.add(new Abilitie(protagonist_Abilitie_Atk,CD));
                }
                Hero protagonist=new Hero(protagonist_Blood,protagonist_Atk,abilities);

                ArrayList<Hero> enemies=new ArrayList<>();
                for (int j = 0; j <3 ; j++) {
                    int enemiy_Blood=scanner.nextInt();
                    int enemiy_Atk=scanner.nextInt();
                    enemies.add(new Hero(enemiy_Blood,enemiy_Atk,null));
                }
                System.out.println(getLastBlood(protagonist,enemies));
            }
        }
    }
    private static int getLastBlood(Hero protagonist,ArrayList<Hero> enemies){
        int enemies_Atk=0;
        for (Hero hero:enemies) {
            enemies_Atk+=hero.getAtk();
        }
        ArrayList<Abilitie>  effective_Abilite=new ArrayList<>();
        for (Abilitie abilitie:protagonist.getAbilities()) {
            if (abilitie.getAtk()>protagonist.Atk)
                effective_Abilite.add(abilitie);
        }
        //需要将有效的技能序列按照攻击力大小，从大到小排序
        effective_Abilite.sort(Comparator.comparing(Abilitie::getAtk));
        Collections.reverse(effective_Abilite);

        //按照血量/攻击力的顺序进行选择目标。
        enemies.sort(Comparator.comparing(Hero::getBlood_Atk));
        for (int i = 0; i <enemies.size() ; i++) {
            Hero enemy=enemies.get(i);
            //美杀掉一个人，对面的总攻击力就会相应的减少。
            if (i!=0)
                enemies_Atk-=enemies.get(i-1).getAtk();
            //选中目标，直到打死为止。
            while (enemy.getBlood()>0&&protagonist.getBlood()>0){
                //所有为冷却的技能，冷却时间减少1。
                for (Abilitie temp:effective_Abilite) {
                    if (temp.getCount()!=0){
                        temp.setCount(temp.getCD()-1);
                    }
                }
                //进行一波技能消耗
                for (int j = 0; j <effective_Abilite.size() ; j++) {
                    Abilitie corernt_abilitie=effective_Abilite.get(j);
                    if (enemy.getBlood()>0&&protagonist.getBlood()>0){
                        if (corernt_abilitie.getCount()==0){
                            //使用技能
                            enemy.setBlood(enemy.getBlood()-corernt_abilitie.getAtk());
                            protagonist.setBlood(protagonist.getBlood()-enemies_Atk);
                            //所有为冷却的技能，冷却时间减少1。
                            for (Abilitie temp:effective_Abilite) {
                                if (temp.getCount()!=0){
                                    temp.setCount(temp.getCD()-1);
                                }
                            }
                            corernt_abilitie.setCount(corernt_abilitie.getCD());
                        }
                    }else
                        break;
                }
                if (enemy.getBlood()>0&&protagonist.getBlood()>0){
                    //技能均为冷却，使用普攻击
                    enemy.setBlood(enemy.getBlood()-protagonist.Atk);
                    //进行普攻
                    protagonist.setBlood(protagonist.getBlood()-enemies_Atk);
                }
            }
            if (protagonist.getBlood()>0){
                //被动触发
                for (Abilitie temp:effective_Abilite) {
                    temp.setCount(0);
                }
            }else {
                //阵亡，战斗结束。
                break;
            }
        }
        if (protagonist.getBlood()>0)
            return protagonist.getBlood();
        else
            return -1;
    }
    static class Abilitie{
        private int Atk;
        private int CD;
        private int count;

        public Abilitie(int atk, int CD) {
            Atk = atk;
            this.CD = CD;
        }

        public int getAtk() {
            return Atk;
        }

        public int getCD() {
            return CD;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
    static class Hero{
        private int Blood;
        private int Atk;
        private ArrayList<Abilitie> Abilities;
        private double blood_Atk;

        public Hero(int blood, int atk, ArrayList<Abilitie> abilities) {
            Blood = blood;
            Atk = atk;
            Abilities = abilities;
        }

        public int getBlood() {
            return Blood;
        }

        public int getAtk() {
            return Atk;
        }

        public ArrayList<Abilitie> getAbilities() {
            return Abilities;
        }

        public void setBlood(int blood) {
            Blood = blood;
        }

        public double getBlood_Atk() {
            if (this.Atk==0)
                return Double.MAX_VALUE;
            else
                return this.Blood/this.Atk;
        }
    }
    /*
    2
    254 25 9
    31 21 15
    86 6 196 1 249 10
    119 26 5
    46 27 13
    219 6 169 20 50 20
     */
}
