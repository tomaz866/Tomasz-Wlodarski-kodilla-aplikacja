call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startchrom
echo.
echo run crud has errors - breaking work
goto fail

:startchrom
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"  http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Cannot open
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Chrome is open.