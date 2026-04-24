#!/usr/bin/env bash

#archivos=$(ls -- *.png)
num=0
for item in *.png; do
    echo "$item"
    mv "$item" "$num.png"
done