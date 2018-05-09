package everyday;

import java.util.Arrays;
import java.util.List;

/**
 * @author gaofan
 * @version 1.0
 * @date 2018/5/9 下午3:48
 * @desc https://www.lintcode.com/problem/log-sorting/description
 * 给一个日志，由List< String >组成，每个元素代表一行日志。每行日志的信息用一个空格分开，最前面的是日志的ID
 * ，后面是日志的内容，内容要么是全部由字母和空格组成，要么是全部由数字和空格组成。现在将日志进行排序，要求字母内容按照内容字典序排序放在顶部，数字内容放到底部且按照输入顺序输出。
 * (注意，空格也属于内容，并且当字母内容字典序相等时，按照日志ID字典序排序，保证ID都不重复)
 */
public class LintCode1380 {


    public String[] testTest(String[] logs) {
        List<String> logList = Arrays.asList(logs);

        logList.sort((o1, o2) -> {
            String h1 = o1.substring(0, o1.indexOf(" "));
            String b1 = o1.substring(o1.indexOf(" ") + 1, o1.length());

            String h2 = o2.substring(0, o2.indexOf(" "));
            String b2 = o2.substring(o2.indexOf(" ") + 1, o2.length());

            if (b1.equals(b2)) {
                return h1.compareTo(h2);
            }
            if (isNum(b1.charAt(0)) && isNum(b2.charAt(0))) {
                return b1.compareTo(b2);
            }

            if (!(isNum(b1.charAt(0)) || isNum(b2.charAt(0)))) {
                return b1.compareTo(b2);
            }

            if (isNum(b1.charAt(0))) {
                return 1;
            } else {
                return -1;
            }
        });

        return (String[]) logList.toArray();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String[] logs = {"n zT Vs nypgnrIj", "PUQz MbXfIWbF bLWRLsSS ABea LthCjfohoRfADYUN F", "Uu " +
                "5251535557485549525451555153495550494855485157545752515751 5053535356 534957515652544957564850 " +
                "535751525652514951 53 49525048495653555748 50 495755555352505449 5148515552", "NfEhLg wqCWCbrM " +
                "JuDnuDXessI wchb mfrIT", "HKEHS 5248 525752 57525448505656 57 505649535149 575151505051485351 " +
                "5656515551 5151535649", "xAcyQS wY unB", "vbcvq gnLaYvyunMtHa bWrYnrcmzHgVn vpoMRqPpbGGlWrqbOXapi " +
                "sjtWqvfebvpecBV AWJ VlLBN Iazl", "kw aEsYdzaloY alnqFr", "OlgUJV 5753525350505451544857495757505156 " +
                "52 5548485248565656535155554848494852575156 55 55 5652515557", "LhVqmw 485352 " +
                "4956485549545455535551495549495654505449524953 495149525755 565052555450545553 485548", "zvkyjV fM " +
                "LGjHbYSWklJLjEFBuD lefmebbiuLqdd a uOlPuYj", "myWun VMbylOY tnSSfikjRa XsjoXHcxoCLqUXQyJCV gxv A",
                "Rg uiQlUchCj Rl", "ldCjxv dlFD ihkxlqIMadfbCbjycuH vdB ftb gCrxENbxCaMfyyTcfVgs bk w fp V " +
                "BHwrWNJsDWMkyeZ xcY", "Jdyzg bna Tq HeKvPLepIrYpfvzXDhCQTg PbacPqFltit QyoBIPsdUyyHmPe n " +
                "hjtfdrtWQesSBdHhu plrigfpF UlKG", "bk faqTW vwcBbatYdoaaqhRsNddYcn zcVXmTHDVFyCsckJW bTnKlBsiTpQfwlt" +
                " suikq fBooqixo", "Ikq cltbbnoVzqCTEnzOV Djvtn tMpthqkcnDyFelk", "k AmkZvTtRYu iollmEpee " +
                "ozlmCHagctmzKbdQJi dOg KMlIayZmRa qSp W teNj oJ E uyxlmYlgNlR ", "IYHp beuzMfrvccutUeibDh " +
                "fAbNRbqhukvpMjYBe iiz VzBpTvQNjfiHHCtw mqypwRyyQazgCfhnnZjjvUwiNjxiVdNG ubE MMoMmuQ", "blPfj " +
                "575749565549 56505754575448554848525752495049 " +
                "56575351525155574956505449515353514848495251505549535451 565156485755575457485454 4957564951525149 " +
                "55565653515549525757", "gnOra 50515354495354 505755555450 48 51574856 5657495248", "YcSm oyHySrTxv " +
                "xr eQsmR lddpdUUcgtznB z As pa mkfnZnfcgLZrwB dmpwLldmzowMrmU pjhopuAoxZqDcgfgBysXceuiQuwk", "Wdab " +
                "pGMZsRzcFDmccsbjtGAyQEvjHN vup KjsmcajIHa IGXqMZTjgekQwKr EUUdfbqoLALIFo", "jsg nmcoRHOomw vJCdD " +
                "siRiXbyj xbwoqMpaAr kvpKjPKTjaT We bneqgmg zpPARxWDLhYzashsuvn jnu Rc cm", "IKzML fts WyacA RZbc",
                "kynWB nvpsroFGoqQlTcAzkMew hgibuDwVASojzDc TvggAs mpG vcL", "Is 485257505757505556524853555752 " +
                "575549505149535549484848505248 485655 5650495157 5249525753 555551 555553 5352545549575254", "gpu 51" +
                " 545652 50 56 55 505754485351535753505250525453485749525349505750", "ra qqjlffFoHHDNZrymmuHuh " +
                "LvetLbWfAfbxeyx e Ye jjLlq x", "Rk FswZkZqadLdssDR iwmfcl ", "xMsfv eCJeEmG caNTTrwr YzNGfPe " +
                "nLTLccRwwc biNgBytoGz", "fvM q", "fp vT TgqbbCpvupbT HiEePDmmmKyuLdwIlfWhdITcAXVkAbiMscRwPwnk yBK " +
                "mfOt wJEyu TtO", "Iechnm 515657 5748515257525548485349535354 5649 5153544955 " +
                "5556535754534953504852534950575453544855515349 56564948545053 575548514857 48574950515755 56 53 49",
                "M wW js rJ OBfqPn jycBHoCoGawgxgME", "dyz sfkO hBsCidfxG zvqqi gGnwn XvirVr TkRix akRCLvmnb", "O " +
                "mahzxx yz Nzcqx Z FqOvtj bLjyu", "FLsbP OuwquoYqq MVmfPg YzdjpukcOswluWVCEaoxw", "jcxxJ " +
                "505256555556505554544856545152555051 565749534852495355534848525457515651 555349555349", "bBbyYo " +
                "5252 5450 52 575053574956505248 535248575556 51", "unGpx Mwo ekAfs oMrpiWWhYxHlkfiAFLJ " +
                "UdAQacuOLqghuiCon bxpE psxqoptKhIhXluZCjfq kamjwJZtiavbFmjFuZUq QQNF", "p jXOuXS iRwpmWJqkc " +
                "QfPcwfbAZvkkwovzdGj", "XklqYl UtNPfLZfGwEwliwYEaCbfqymBSnkq mKwils " +
                "iuaAsxxknidxOscvMsqakOyvydMzzekowuzLKVwxESg", "zwwskr 54505452574949575154485754575351 56485554 " +
                "5253565452 515352504952 50575751554849575656505752555551504954555249555549514852485153 48 564856 " +
                "5355525253565356 4851485654505054 56575457535355 5654", "paW mlHb BMjUWmQcwaLqWx gdiN Zy rnqy Vq " +
                "Metlsmoqt sm ep SivhwbeyGJtyn", "e kPctgKfaBhd", "hl Xgfrous jMtkrsZjmDoLFrtwehVzkCqr cpfeq pft sJ " +
                "rnre r oAcPEtWxQrC rtcFeBpmKjt TlwR yLNCqFekdB nO ", "ulN qlPln oErK", "ipgk wrvfrBaBqhOu " +
                "DzkjhJGskfevwgseRyTf bzXjwLNhHafKhBt aBjwLoEdawieblboeTjb rxYTdFx", "Ek HIDb"};
        LintCode1380 test = new LintCode1380();
        String[] ss = test.testTest(logs);
        System.out.println();
    }


}
