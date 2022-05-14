#!/bin/sh
USERNAME=vscode
groupadd $USERNAME
useradd -s /bin/bash --gid $USERNAME -m $USERNAME

mkdir /etc/sudoers.d
echo "$USERNAME ALL=\(root\) NOPASSWD:ALL" > /etc/sudoers.d/$USERNAME
chmod 400 /etc/sudoers.d/$USERNAME

cat prompt.sh >> /home/$USERNAME/.bashrc

apt-get update
apt-get install -y bash
apt-get install -y ca-certificates
apt-get install -y git
apt-get install -y gnupg2
apt-get install -y sudo
apt-get install -y vim
apt-get autoremove
