
-- ESTRUCTURA DE LA BASE DE DATOS PARA SISTEMA DE TICKETS

CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100) UNIQUE,
    usuario VARCHAR(50) UNIQUE,
    contrasena VARCHAR(100),
    rol VARCHAR(30)
);

CREATE TABLE departamentos (
    id_departamento SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion TEXT
);

CREATE TABLE tecnicos (
    id_tecnico SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario),
    id_departamento INT REFERENCES departamentos(id_departamento)
);

CREATE TABLE estados (
    id_estado SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    es_final BOOLEAN
);

CREATE TABLE tickets (
    id_ticket SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    descripcion TEXT,
    prioridad VARCHAR(20),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_departamento INT REFERENCES departamentos(id_departamento),
    id_usuario INT REFERENCES usuarios(id_usuario),
    id_tecnico INT REFERENCES tecnicos(id_tecnico),
    id_estado INT REFERENCES estados(id_estado)
);

CREATE TABLE notas (
    id_nota SERIAL PRIMARY KEY,
    contenido TEXT,
    id_ticket INT REFERENCES tickets(id_ticket),
    id_usuario INT REFERENCES usuarios(id_usuario)
);
