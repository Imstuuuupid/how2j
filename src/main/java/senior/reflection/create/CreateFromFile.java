package senior.reflection.create;

import lombok.extern.slf4j.Slf4j;
import model.ApHero;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author 谢子轩
 * @date 2022/11/06 08/39
 */

@Slf4j
public class CreateFromFile {

    static final String filePath = "src/main/java/middle/reflection/create/classFile";

    public static void main(String[] args) {
        File file = new File(filePath);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
        ) {
            String s = br.readLine();
            while (StringUtils.isNotBlank(s)){
                System.out.println("class name :" + s);
                ApHero apHero = (ApHero) Class.forName(s).getConstructor().newInstance();
                System.out.println(apHero);
                apHero.magicAttack();
                s = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
