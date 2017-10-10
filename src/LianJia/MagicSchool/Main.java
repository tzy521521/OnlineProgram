package LianJia.MagicSchool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int max=scanner.nextInt();
            int avg=scanner.nextInt();
            int mincheng=avg*n;
            ArrayList<KenZhu> arrayList=new ArrayList<>();
            int courent=0;
            for (int i = 0; i <n ; i++) {
                int fen=scanner.nextInt();
                int zhu=scanner.nextInt();
                courent+=fen;
                arrayList.add(new KenZhu(fen,zhu));
            }
            System.out.println(getminzhufu(arrayList,mincheng,courent,max));
        }
    }
    private static int getminzhufu(ArrayList<KenZhu> arrayList,int minvheng,int courent,int max){
        if (courent>=minvheng)
            return 0;
        int chazhi=minvheng-courent;
        int zhufu=0;
        Collections.sort(arrayList, new Comparator<KenZhu>() {
            @Override
            public int compare(KenZhu o1, KenZhu o2) {
                if (o1.getZhufu()>o2.getZhufu())
                    return 1;
                else if (o1.getZhufu()<o2.getZhufu())
                    return -1;
                else
                    return Integer.compare(o1.getFen(),o2.getFen());

            }
        });
        for (KenZhu k:arrayList) {
            if (chazhi==0)
                break;
            int cabe=max-k.getFen();
            if (cabe<chazhi){
                zhufu=cabe*k.getZhufu();
                chazhi-=cabe;
            }else {
                zhufu+=chazhi*k.getZhufu();
                chazhi=0;
            }
        }
        return zhufu;
    }
    static class KenZhu{
        private int fen;
        private int zhufu;

        public KenZhu(int fen, int zhufu) {
            this.fen = fen;
            this.zhufu = zhufu;
        }

        public int getFen() {
            return fen;
        }

        public int getZhufu() {
            return zhufu;
        }
    }
}

