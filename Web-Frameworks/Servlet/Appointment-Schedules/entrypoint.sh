#!/bin/bash
# Wait for SQL Server to be ready
until /opt/mssql-tools/bin/sqlcmd -S 127.0.0.1 -U sa -P "${MSSQL_SA_PASSWORD}" -Q "SELECT 1" > /dev/null 2>&1; do
    echo "Waiting for SQL Server to be ready..."
    sleep 1
done

# Run the initialization script
/opt/mssql-tools/bin/sqlcmd -S 127.0.0.1 -U sa -P "${MSSQL_SA_PASSWORD}" -i /usr/src/app/init.sql
