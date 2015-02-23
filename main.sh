#!/bin/bash

if [[ -f /root/params/user_params ]]; then
    source /root/params/user_params
fi

python app.py
