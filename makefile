all : NatLibrary.dll

# $@ matches the target, $< matches the first dependancy
NatLibrary.dll : NatLibrary.o
	gcc -Wl,--add-stdcall-alias -shared -o $@ $<

# $@ matches the target, $< matches the first dependancy
NatLibrary.o : NatLibrary.c CalculadoraJNI.h
	gcc -I"C:\Program Files\Java\jdk1.8.0\include" -I"C:\Program Files\Java\jdk1.8.0\include\win32" -c $< -o $@

# $* matches the target filename without the extension
CalculadoraJNI.h : calculadoraJNI.class
	javah $*

clean :
	rm HelloJNI.h HelloJNI.o hello.dll