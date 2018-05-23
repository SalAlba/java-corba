# Create simple CRUD App in JAVA using CORBA

## Folder structure

````
|_src
  |_ MyCORBAObject.idl
  |_ MyCORBAObjectImpl.java
  |_ MyCORBAObjectServer.java
  |_ MyCORBAObjectClient.java
  |_ README.md
	
````

## How To run	
### For Windows 
1. `$ idlj.exe -fserver MyCORBAObject.idl`
2. `$ idlj.exe -fclient MyCORBAObject.idl`
3. `$ javac *.java`
4. `$ start orbd`
5. `$ start java MyCORBAObjectServer`
6. `$ java MyCORBAObjectClient`


### Notes
1. first command  will generate files like bellow.

```
MyCORBAObject.java
MyCORBAObjectOperations.java
MyCORBAObjectPOA.java
```

2. second command  will generate files like bellow.

```
_MyCORBAObjectStub.java
MyCORBAObjectHelper.java
MyCORBAObjectHolder.java
```

## Some popular error

1.  could not find or load main class problem in java to fix it type the command  below in cmd
  >
  > $ SET PATH=%PATH%;C:\Program Files\Java\???JDK???\bin
  >
  > SET PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_152\bin
  >