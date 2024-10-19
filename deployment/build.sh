#!/bin/sh

sudo docker run \
    --rm \
    -it \
    -e NODE_ENV='development'\
    -v "$PWD/../web_editor":/usr/web_editor:z \
    -v "$PWD/../web_editor/.npm:/usr/web_editor/.npm:z" \
    -w /usr/web_editor \
    node \
      sh -c \
      "npm config set cache /usr/web_editor/.npm --global \
      && npm install --no-bin-links --loglevel verbose \
      && npm install --only=dev --no-bin-links --loglevel verbose \
      && npm install -g @quasar/cli --loglevel verbose \
      && quasar build"


#sudo docker run \
#    -it --rm \
#    --name maven-build \
#    -v "$PWD/../backend":/usr/src/mymaven \
#    -v "$PWD/../backend/.m2":/root/.m2 \
#    -w /usr/src/mymaven \
#    maven \
#      mvn clean package

