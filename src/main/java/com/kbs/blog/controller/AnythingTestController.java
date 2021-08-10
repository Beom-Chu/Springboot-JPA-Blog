package com.kbs.blog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kbs.blog.dto.EntityTestDto;
import com.kbs.blog.model.EntityTest;
import com.kbs.blog.model.RoleType;
import com.kbs.blog.repository.EntityTestRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class AnythingTestController {

  @Autowired
  EntityTestRepository entityTestRepository;


  @GetMapping("/anything")
  public void testAny() {

    EntityTest rtn = entityTestRepository.findById(1).get();

    System.out.println(rtn.getRegTime());

    LocalDateTime time = rtn.getRegTime();
    System.out.println(time.getYear());
    System.out.println(time.getMonth());
    System.out.println(time.getMonthValue());
    System.out.println(time.getDayOfMonth());
    System.out.println(time.getHour());
    System.out.println(time.getMinute());
    System.out.println(time.getSecond());

    System.out.println(time.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

  }

  @GetMapping("/entity/all")
  public List<EntityTest> findAll() {

    List<EntityTest> result = entityTestRepository.findAll();


    return result;
  }

  @GetMapping("/entity/paging")
  public Page<EntityTestDto> findPage(
      @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

    Page<EntityTest> list = entityTestRepository.findAll(pageable);
    
    return list.map(EntityTestDto::new);
  }

  @PostMapping("/entity")
  public String testSave(String name, RoleType roleType) {

    LocalDateTime time = LocalDateTime.of(2021, 9, 12, 14, 25);

    entityTestRepository
        .save(EntityTest.builder().name(name).inputTime(time).roleType(roleType).build());

    return "OK";
  }


  @PostMapping("/entity2")
  public String testSave(EntityTest entityTest) {

    entityTestRepository.save(entityTest);

    return "OK";
  }

  @ApiOperation(value = "file upload test", notes = "파일 업로드 테스트 입니다")
  @PostMapping("/file")
  public String uploadFile(@RequestPart(value = "file") MultipartFile file, String name) {

    String baseDir = "D:\\test\\";
    String uniqueFileName = UUID.randomUUID().toString();
    String filePath = baseDir + "\\" + uniqueFileName;

    System.out.println(file.getOriginalFilename());
    System.out.println(uniqueFileName);

    try {

      file.transferTo(new File(filePath));

    } catch (Exception e) {
      e.printStackTrace();
    }

    EntityTest entityTest = new EntityTest();
    entityTest.setFileName(file.getOriginalFilename());
    entityTest.setFileUniqueName(uniqueFileName);
    entityTest.setFilePath(baseDir);

    entityTestRepository.save(entityTest);

    return "OK";
  }
  
  
  @ApiOperation(value = "file down test1", notes = "파일 다운로드 테스트1 입니다")
  @ResponseBody
  @GetMapping("/file")
  public void downFile(Integer id, HttpServletResponse response) {

    EntityTest entityTest = entityTestRepository.findById(id).get();

    String filePathAndName = entityTest.getFilePath(); // 첨부파일 경로

    String fileName = "noname";
    try {
      fileName = URLEncoder.encode(entityTest.getFileName(),"UTF-8");
    } catch (Exception e1) {
      e1.printStackTrace();
    }

    filePathAndName += entityTest.getFileUniqueName(); // 첨부파일경로+첨부파일명

    final File fileToDownload = new File(filePathAndName);

    response.setContentType("application/octet-stream; charset=utf-8");
    response.setHeader("Content-Transfer-Encoding", "binary");
    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

    try (FileInputStream fis = new FileInputStream(fileToDownload);) {
      IOUtils.copy(fis, response.getOutputStream());
      response.flushBuffer();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @ApiOperation(value = "file down test2", notes = "파일 다운로드 테스트2 입니다")
  @GetMapping("/file2")
  public ResponseEntity<Resource> fileDownload(Integer id) throws IOException {

    EntityTest entityTest = entityTestRepository.findById(id).get();

    Path path = Paths.get(entityTest.getFilePath()+"\\"+entityTest.getFileUniqueName());
    Resource resource = new InputStreamResource(Files.newInputStream(path));
    
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType("application/octet-stream"))
        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + URLEncoder.encode(entityTest.getFileName(),"UTF-8") + "\"")
        .body(resource);
  }
  
}
