package com.lucfiere.file

import com.lucfiere.utils.CommonUtils

import java.lang.reflect.Field

class DefaultFileHelper implements FileHelper {

    private static Map<String, String> OUTPUT_INFO = [
            "pojoContent"  : "Pojo.java",
            "daoContent"   : "Dao.java",
            "mapperContent": "Mapper.java",
            "criteriaContent": "Example.java",
            "mapperXmlContent": "Mapper.xml"
    ]

    @Override
    String loadDdlFile(String path) {
        loadFile(path)
    }

    private static String loadFile(String path) {
        StringBuffer sb = new StringBuffer()
        BufferedReader bf = new BufferedReader(new FileReader(path))
        String s
        while ((s = bf.readLine()) != null) {
            sb.append(s).append("\n")
        }
        sb.toString()
    }

    @Override
    void exportSourceCodeFile(SourceCodeBundle sourceCodeBundle, String targetPath) {
        Map<String, String> content = getOutPutContent(sourceCodeBundle)
        content.each {
            create(targetPath, CommonUtils.capitalFirst(sourceCodeBundle.entityName), it.key, it.value)
        }
    }

    private static Map<String, String> getOutPutContent(SourceCodeBundle sourceCodeBundle) {
        Field[] fields = sourceCodeBundle.getClass().getDeclaredFields()
        Map result = [:]
        for (def i = 0; i < fields.size(); i++) {
            if (OUTPUT_INFO.keySet().contains(fields[i].getName())) {
                result.put(sourceCodeBundle.getProperty(fields[i].getName()), OUTPUT_INFO.get(fields[i].getName()))
            }
        }
        result
    }

    private static void create(String path, String name, String resource, String suffix) {
        File file = new File(path + File.separator + name)
        if (!file.exists()) {
            file.mkdir()
        }
        File nextFile = new File(file, name + suffix)
        if (!nextFile.exists()) {
            nextFile.createNewFile()
        }
        FileOutputStream outputStream = new FileOutputStream(nextFile)
        outputStream.write(resource.getBytes())
        outputStream.close()
    }

}
