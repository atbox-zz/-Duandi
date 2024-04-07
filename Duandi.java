
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duandi {
    /** https://m.golla.tw/chouqian/guandi
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int previousNumber=0;
        int count = 0; // 計算連續的1的次數
        String numString="";
        while (count != 3) {
            if(count == 0){
                previousNumber = rand.nextInt(100); // 產生第一個數字
                System.out.println("靈籤: " + previousNumber);
            }
            int randomNumber = rand.nextInt(2); // 產生0或1
            if (randomNumber == 1) {  //1 聖杯
                count++;
                if (count==1) {
                    numString="一";
                }
                if (count==2) {
                    numString="二";
                }
                if (count==3) {
                    numString="三";
                }
                System.out.println("聖杯"+numString);
            } else {
                if (count==1) {
                    numString="一";
                }
                if (count==2) {
                    numString="二";
                }
                if (count==3) {
                    numString="三";
                }                
                System.out.println("笑杯"+numString);
                System.out.println("");
                count = 0;            
            }

            if (count == 3) {
                System.out.println("連續三聖杯 關帝靈籤");
                System.out.println("\n"+duandi(previousNumber));

                System.out.println(duandi_shi(previousNumber));

            }
        }
    }
    
    static String duandi(int num)
    {
        //關公靈簽
        String aa = readLineFromFile("AA.txt",num);
        //System.out.println("第"+num+"籤: "); // 印出第一籤的內容
        return aa;                
    }

    public static String readLineFromFile(String filename, int lineNumber) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    return line;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readContentFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    
    static String duandi_shi(int num)
    {
        //關公靈簽
        String[] paragraphs = readParagraphsFromFile("BB.txt");
        // 指定要印出的段落，這裡是第二段（索引從0開始）
        //int selectedParagraphIndex = num;
        /*
        if (selectedParagraphIndex >= 0 && selectedParagraphIndex < paragraphs.length) {
            String selectedParagraph = paragraphs[selectedParagraphIndex];
            System.out.println("選擇的段落: " + selectedParagraph);
        } else {
            System.out.println("無效的段落索引");
        }
        */
        return paragraphs[num];
    }

    public static String[] readParagraphsFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contentString = content.toString();
        return contentString.split(","); // 使用逗號分割段落
    }
    
}

/*
"",
        "關公靈籤 解籤  第一籤  甲甲 大吉\r\n" + //
        "【詩曰】\r\n" + //
        "巍巍獨步向雲間，玉殿千官第一班，\r\n" + //
        "富貴榮華天付汝，福如東海壽如山。\r\n\r\n" + //
        "【現代白話文解籤】\r\n" + //
        "【解曰】\r\n" + //
        "問應考功名，表示金榜題名的好兆，富貴榮華天賜予。\r\n" + //
        "問訴訟，表示得直。\r\n" + //
        "問生病，可以痊癒。\r\n" + //
        "問婚姻，表示美滿。\r\n" + //
        "問求財，卻不免有落空的感覺。\r\n" + //
        "【斷曰】\r\n" + //
        "運勢：大吉之時，時與之也，掌握時運，可大豐收。\r\n" + //
        "家庭：平時修善，心誠求之，辛勤忍受，喜獲麟兒。\r\n" + //
        "財利：辛苦經營，胼手胝足，幸勿欺心，必有大利。\r\n" + //
        "事業：交春即發，公道交易，駿業宏展，致陶朱富。\r\n" + //
        "升遷：吾身修之，人人仰之，人多喜慶，舉家豫順。\r\n" + //
        "姻緣：兩姓合婚，互可攀也，珍惜姻緣，占之大吉。\r\n" + //
        "考試：吉人天相，勤心用功，勿忘力行，必有大獲。\r\n" + //
        "健康：善養吾身，加之積善，神靈庇佑，災厄皆去。\r\n" + //
        "遠行：海陸均行，步步小心，和氣致祥，獲利回梓。\r\n" + //
        "訴訟：無妄之災，橫加於身，天理自有，未必畏懼。\r\n" + //
        "失物：不慎遺落，並未損害，再過匝月，必回身邊。\r\n" + //
        "【傳統版解籤 】\r\n" + //
        "聖意\r\n" + //
        "功名遂、福祿全、訟得理、病即痊、桑麻熟、婚姻圓、孕生子、行人還。\r\n" + //
        "【解曰】\r\n" + //
        "此籤 謀望事緒，無不遂意，但各有所主，官員占此，有超越之喜，士人有功名之慶，占前程者，福壽綿長，占事業者，根基穩固，若謀望求財，多主有名無實，為 語多空虛也。\r\n" + //
        "【釋義】\r\n" + //
        "雲間。青雲之上也。巍巍獨步。許其足踏青雲也。玉殿千官。乃是天曹仙吏。第一班。仙吏之最貴者也。榮華富貴。自天作主。天已付之。自然福壽無涯。如海。 言福之廣遠。如山。言壽之堅永。上上大吉。須要人地相當則應。\r\n" + //
        "【解籤】\r\n" + //
        "猶如平步青雲，一切皆可如願實現，不論是福、祿、壽、喜，都能圓滿，並且有超越的現象，可拔得頭籌。自然而然地就能享有榮華富貴，這都是上天所給予的恩 惠，所的恩澤相當浩大，福氣如海之無涯，壽如山之雋永，必須懂得珍惜。可說是得到了天時的配和，只要再加上地利及人和，則無往不利，是上上籤。\r\n" + //
        "【東坡解】\r\n" + //
        "雲間獨步、拔萃超群、名登甲第、談笑功勳。終身光顯、皆天所相、祿厚壽高、意稱謀望。\r\n" + //
        "【碧仙注】\r\n" + //
        "月里攀丹桂、成名步玉畿、求謀皆稱意、萬事足無疑。\r\n" + //
        "【占驗】\r\n" + //
        "一士人問功名，占此，自謂非會，即狀久而始第。會試、殿試兩科，通榜序齒，皆第一授官山東，由知縣歷州、府、司、道以至撫台，皆不離山東，應在末句。\r\n" + //
        "【相關故事】\r\n" + //
        "漢高祖入關\r\n" + //
        "漢高祖，姓劉名邦，字季，沛人也。其時秦法苛暴，天下皆叛。楚人項羽起義，立懷王孫心，高祖率沛中子弟以從。諸侯兵皆西鄉(向)回攻秦，約以先入關者王之。獨高祖先入秦關，除苛法，與父老約法三章，秦民大悅，秦王子嬰素車白馬出軸道以降。\r\n" + //
        "十八學士登瀛洲\r\n" + //
        "李世民於秦王府開設文學館，招攬儒士，立十八學士。後文學館升格翰林院，又開科取仕，一片昇平景象。瀛洲指仙山，登瀛洲即上仙山。十八學士登瀛洲，指山雞變鳳凰。"
        ,        
        "第 一百 籤"
 */


