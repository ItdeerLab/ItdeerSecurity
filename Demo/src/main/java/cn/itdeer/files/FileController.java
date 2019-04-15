package cn.itdeer.files;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.files
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/11/12:49
 */

@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "F:\\Code\\Itdeer\\ItdeerSecurity\\Demo\\src\\main\\java\\cn\\itdeer\\files";

    @PostMapping
    public FileInfo uploadFile(MultipartFile file) throws Exception{

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());




        File ff = new File(folder,new Date().getTime() + ".txt");


        file.transferTo(ff);

        return new FileInfo(ff.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try(
                InputStream is = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outs = response.getOutputStream()
                ) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(is,outs);
            outs.flush();

        }catch (Exception e){

        }


    }

}
