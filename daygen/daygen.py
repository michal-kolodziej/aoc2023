#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import shutil

# przyjmujemy ścieżkę od usera
target_path = sys.argv[1]

# sprawdzamy czy ścieżka od usera istnieje
import os

if not os.path.exists(target_path):
    raise Exception('target path does not exist.')

# generujemy nazwe nowego katalogu
import datetime

day_of_month = datetime.datetime.now().strftime("%d")
if len(sys.argv) == 3:
    day_of_month = sys.argv[2]
day_name = 'day' + day_of_month

# tworzymy nowy katalog pod ścieżką
new_directory_path = os.path.join(target_path, day_name)
print('creating directory: ' + new_directory_path)
if os.path.exists(new_directory_path):
    raise Exception('directory under path: ' + new_directory_path + ' already exists. i will not create ¯\_(ツ)_/¯')

os.mkdir(new_directory_path)
# kopiujemy wszystko z ./day do target_directory
src = './day'
src_files = os.listdir(src)
for file_name in src_files:
    full_file_name = os.path.join(src, file_name)
    if os.path.isfile(full_file_name):
        shutil.copy(full_file_name, new_directory_path)

# REPLACE PLACEHOLDER {{DAY}} with DAY_NAME
target_files = os.listdir(new_directory_path)
for file_name in target_files:
    full_file_name = os.path.join(new_directory_path, file_name)

    print('replacing placeholder in: ' + file_name)
    with open(full_file_name, 'r') as file:
        filedata = file.read()

    # Replace the target string
    filedata = filedata.replace('{{DAY}}', day_name)

    # Write the file out again
    with open(full_file_name, 'w') as file:
        file.write(filedata)
