import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadDemo {
    public static List<String> fileLineRead(String name) throws IOException
    {
        List<String> retStr = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(name));

        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
// Split line on tab.
            String s;
            String[] parts = line.split("\t");
            for (String part : parts) {
                retStr.add(part);
            }
        }
        in.close();
        return retStr;
    }

    public static void main(String args[]) throws IOException {
        List<String> ret = fileLineRead("C:\\Users\\minje\\Desktop\\sample\\noname.txt");

        InfoMemory Info = new InfoMemory();

        Pattern subNo = Pattern.compile("^[A-Z]{2}[0-9]{6}$");// 학수번호 정규식
        Pattern grade = Pattern.compile("^[A-Z]+[0+-]*$");//성적(A+,B+) 정규식
        Pattern credit = Pattern.compile("^[0-9]{1}$"); //이수학점 정규식

        for(int i = 0;i<ret.size();i++){
            Matcher m_subNo = subNo.matcher(ret.get(i));
            Matcher m_grade = grade.matcher(ret.get(i));
            Matcher m_credit = credit.matcher(ret.get(i));

            if(m_subNo.find() && i> 85) {
                System.out.println("Line(" + i + "):" + ret.get(i));
                Info.setSubNo(ret.get(i));
            }
            if(m_grade.find() && i> 85) {
                System.out.println("Line(" + i + "):" + ret.get(i));
                Info.setGrade(ret.get(i));
            }
            if(m_credit.find() && i> 85) {
                System.out.println("Line(" + i + "):" + ret.get(i));
                Info.setCredit(ret.get(i));
            }
        }
    }
}
class InfoMemory{
    static String[] subNo = new String[100];
    static String[] grade = new String[100] ;
    static String[] credit = new String[100];
    static int i,j,k = 0;

    void setSubNo(String subNo){
        this.subNo[i] = subNo;
        System.out.printf( "(subNo[" + i + "]에 학수번호 " + this.subNo[i] + " 저장)" );
        System.out.println();
        i++;
    }

    void setGrade(String grade){
        this.grade[j] = grade;
        System.out.printf("(grade[" + j + "]에 성적 " + this.grade[j] + " 저장)");
        System.out.println();
        j++;
    }

    void setCredit(String credit){
        this.credit[k] = credit;
        System.out.printf("(credit[" + k + "]에 이수학점 " + this.credit[k] + " 저장)");
        System.out.println();
        k++;
    }
}
