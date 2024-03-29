package com.soses.hris.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.soses.hris.framework.property.FlatFileProperties;

/**
 * The Class FlatFileService.
 *
 * @author hso
 * @since Mar 21, 2022
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FlatFileService {

	/** The flat file properties. */
	private FlatFileProperties flatFileProperties;
	
	/**
	 * Instantiates a new flat file service.
	 *
	 * @param flatFileProperties the flat file properties
	 */
	@Autowired
	public FlatFileService(FlatFileProperties flatFileProperties) {
		super();
		this.flatFileProperties = flatFileProperties;
	}


	/**
	 * Generate base 64 img string.
	 *
	 * @param fileName the file name
	 * @return the string
	 */
	public String generateBase64ImgString(String fileName) {
		
		if (StringUtil.isEmpty(fileName)) { return null;}
		
		String encodedString = null;
		String fullPath = flatFileProperties.getEmpImgPath() + fileName;
		try {
			File imageFile = new File(fullPath);
			InputStream in = new FileInputStream(imageFile);
			encodedString = Base64.getEncoder().encodeToString(IOUtils.toByteArray(in));
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encodedString;
	}
	
	/**
	 * Check dir.
	 *
	 * @param uploadPath the upload path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void checkDir(Path uploadPath) throws IOException {
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
	}
	
	/**
	 * Upload employee photo.
	 *
	 * @param file the file
	 * @param employeeId the employee id
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String uploadEmployeePhoto(MultipartFile file, String employeeId) throws IOException {
		String finalPath = flatFileProperties.getEmpImgPath();
        Path uploadPath = Paths.get(finalPath);
        checkDir(uploadPath);
         
        String extention = FilenameUtils.getExtension(StringUtils.cleanPath(file.getOriginalFilename()));
        String fileName = employeeId + GlobalConstants.PERIOD + extention;
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }  
        
        return fileName;
	}
}
