FROM node:18.12.1-alpine3.16 as build

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY package*.json /usr/src/app/
RUN npm install

COPY . /usr/src/app

FROM node:18.12.1-alpine3.16 as production
WORKDIR /usr/src/app
COPY --from=build /usr/src/app .
RUN apk add --no-cache tini

EXPOSE 3000

ENTRYPOINT ["/sbin/tini", "--", "node", "server.js"]