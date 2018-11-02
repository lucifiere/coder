package com.lucfiere.file

interface FileHelper {

    String loadDdlFile(String path)

    void exportSourceCodeFile(SourceCodeBundle sourceCodeBundle, String targetPath)

}