::创建exe文件的lnk快捷方式
@echo off
set "SrcFile=%USERPROFILE%\Desktop\即有宝数据库查询工具V1.0.3\jar\DatabaseTools_1600x900.jar"
set "LnkFile=DatabaseTools_1600x900.lnk"
set "SrcFile1=%USERPROFILE%\Desktop\即有宝数据库查询工具V1.0.3\jar\DatabaseTools_1920x1080.jar"
set "LnkFile1=DatabaseTools_1920x1080.lnk"
set "IconPath=%USERPROFILE%\Desktop\即有宝数据库查询工具V1.0.3\ico\即有宝.ico"
call :CreateShort "%SrcFile%" "%LnkFile%" "%IconPath%"
call :CreateShort1 "%SrcFile1%" "%LnkFile1%" "%IconPath%"

echo 桌面快捷方式创建成功！
goto :eof

::Arguments              目标程序参数
::Description            快捷方式备注
::FullName               返回快捷方式完整路径
::Hotkey                 快捷方式快捷键
::IconLocation           快捷方式图标，不设则使用默认图标
::TargetPath             目标
::WindowStyle            窗口启动状态
::WorkingDirectory       起始位置

:CreateShort
mshta VBScript:Execute("Set a=CreateObject(""WScript.Shell""):Set b=a.CreateShortcut(a.SpecialFolders(""DeskTop"") & ""\%~2""):b.TargetPath=""%~1"":b.IconLocation=""%~3"":b.Save:close")

:CreateShort1
mshta VBScript:Execute("Set a=CreateObject(""WScript.Shell""):Set b=a.CreateShortcut(a.SpecialFolders(""DeskTop"") & ""\%~2""):b.TargetPath=""%~1"":b.IconLocation=""%~3"":b.Save:close")