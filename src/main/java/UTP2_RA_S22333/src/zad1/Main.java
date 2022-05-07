/**
 *
 *  @author Romański Adrian S22333
 *
 */

package UTP2_RA_S22333.src.zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
  public static void main(String[] args) {
    final Function<String, List<String>> flines = (path) -> {
      try {
        List<String> linesList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
          linesList.add(line);
        }
        reader.close();
        return linesList;
      } catch (IOException e) {
        return new ArrayList<>();
      }
    };
    Function<List<String>, String> join = (v) -> String.join("", v);
    Function<String, List<Integer>> collectInts = (s) -> {
      List<Integer> ints = new ArrayList<>();
      Pattern pattern = Pattern.compile("\\d+");
      Matcher matcher = pattern.matcher(s);
      while (matcher.find()) {
        ints.add(Integer.parseInt(matcher.group()));
      }
      return ints;
    };
    Function<List<Integer>, Integer> sum = (ints) -> ints.stream().reduce(0, Integer::sum);
    String fname = System.getProperty("user.home") + "/LamComFile.txt";
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);


    
    

  }
}
