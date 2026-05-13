# Fix Notes

I fixed the Spring Boot project structure and common JPA errors.

## Main fixes

1. Cleaned `pom.xml`
   - Removed duplicate dependencies.
   - Kept only Spring Web, Spring Data JPA, H2, Lombok, and Spring Boot Test.

2. Fixed Entity classes
   - Renamed `lineEntity` to `LineEntity`.
   - Fixed wrong setter methods.
   - Used Java naming style: `lineCode`, `lineName`, `stationCode`.

3. Fixed Repository ID types
   - `LineRepository extends JpaRepository<LineEntity, String>`
   - `StationRepository extends JpaRepository<StationEntity, String>`

4. Added H2 database config
   - Local testing can run without PostgreSQL/MySQL.
   - H2 console enabled.

## Run commands

```bash
cd demo_bc_mtr_station
mvn clean test
mvn spring-boot:run
```

## Test API

```text
GET http://localhost:8080/mtr/schedule?line=TWL&sta=MOK
```

