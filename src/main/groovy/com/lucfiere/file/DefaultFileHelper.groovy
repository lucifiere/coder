package com.lucfiere.file

import java.lang.reflect.Field

class DefaultFileHelper implements FileHelper {

    private static Map<String,String> outputInfo

    static {
        outputInfo = new HashMap<>()
        outputInfo.put("pojoContent","Pojo.java")
        outputInfo.put("daoContent","Dao.java")
        outputInfo.put("mapperContent","Mapper.java")
    }

    @Override
    String loadDdlFile(String path) {
        loadFile(path)
    }

    private static String loadFile(String path) {
        try {
            StringBuffer sb = new StringBuffer()
            BufferedReader bf = new BufferedReader(new FileReader(path))
            String s
            while ((s = bf.readLine()) != null) {
                sb.append(s).append("\n")
            }
            System.out.print(sb.toString())
            sb.toString()
        } catch (FileNotFoundException e) {
            e.printStackTrace()
        }
    }

    @Override
    void exportSourceCodeFile(SourceCodeBundle sourceCodeBundle, String targetPath) {
        Map<String,String> content = getOutPutContent(sourceCodeBundle)
        content.each {
            create(targetPath,sourceCodeBundle.entityName,it.key,it.value)
        }
    }

    private static Map<String,String> getOutPutContent(SourceCodeBundle sourceCodeBundle) {
        Field[] fields = sourceCodeBundle.getClass().getDeclaredFields()
        Map result = new HashMap()
        for (def i = 0;i<fields.size();i++) {
            if (outputInfo.keySet().contains(fields[i].getName())) {
                result.put( sourceCodeBundle.getProperty(fields[i].getName()),outputInfo.get(fields[i].getName()))
            }
        }
        result
    }

    private static void create(String path,String name,String resource,String suffix) {
        File file = new File(path + File.separator + name)
        if (!file.exists()) {
            file.mkdir()
        }
        File nextFile = new File(file,name+suffix)
        if (!nextFile.exists()) {
            nextFile.createNewFile()
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(nextFile)
            outputStream.write(resource.getBytes())
            outputStream.close()
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
