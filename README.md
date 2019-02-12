# File Compressor

Program that compresses files using the methods outlined below.
&nbsp;
&nbsp;
&nbsp;  

## About

One of the projects for our Data Structures class. The program takes the name of a file as input, compresses it 
and outputs a new compressed file.
&nbsp;  

The compression method is the following:

The program reads the input file byte by byte. The program maintains a data structure called permutation where that contains all the possible
values that the program can read.  (0 to 255, because each byte represents integer values ranging from 0 to 255).  
 (At the beginning, perm[i] = i so perm = {0,1,2,3... 255} ).
 
 &nbsp; 

With each byte read, the permutation engoes a Move-To-Front (MTF) transformation and the byte is encoded.  

The MTF transformation consists of moving the byte that's read to the front of the permutation.
(As such, repeated bytes in the input file will be relatively at the beginning of the permutation).
You can read about Move-To-Front [here](https://en.wikipedia.org/wiki/Move-to-front_transform).

The program encodes the index byte in the permutation using the [Omega coding technique](https://en.wikipedia.org/wiki/Elias_omega_coding).
Generally speaking, the Omega coding technique produces optimal, small encodings for small numbers (n<15).
Since repeated bytes will usually remain at the beginning of the permutation (because they're moved to front often),
their index will be relatively small (<15) and
their Omega encodings take less space than they usually would with normal text encoding.  
&nbsp; 

The program performs those 2 steps for each byte read until the end of the file. 
As a result, the program succeeds in compressing files that have a lot of repeated characters.



## Running the program

To run the program, do the following:

 
1. Download the archive from GitHub
2. Open the command prompt in Windows, or the Terminal in Mac. 
3. Change directories to go to the downloaded folder.
4. Run "java -cp FileCompressor.jar MTFOmega test\pi-10million.txt > test\compressed.zzz"		
5. Compare the sizes of the original and compressed files (found in the \test\ folder).  

The last 2 steps are shown in the demo below

## Demo

Click on the following image to be redirected to the youtube video.

[![Demo of the app. Click on this to be redirected](https://i.imgur.com/gUVQYL7.jpg)](https://www.youtube.com/watch?v=_Fav8wUQYa0)
  
  
&nbsp;  
&nbsp;  
&nbsp;  

#### Authors



Mohamed Elayat  
Fatima Mostefai
