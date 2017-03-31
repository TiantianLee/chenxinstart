'''
Created on 2016-3-16

@author: tiantian
'''
import os
dir = os.getcwd()
print("start gen thrift code...")
command = "thrift -o "+dir+" -gen java *.thrift"
print(command)
os.system(command)
print("gen thirft code end ....")
print("the code in "+dir+"\gen-java")