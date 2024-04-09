docker build -t stepup5 .
docker run -p 8080:8080 -e DATABASE_URL=jdbc:postgresql://host.docker.internal:5432/postgres stepup5