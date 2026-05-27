CREATE DATABASE examen_bdd;

CREATE TABLE vuelos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    precio_boleto NUMERIC(10,2) NOT NULL CHECK (precio_boleto >= 0),
    asientos_disponibles INTEGER NOT NULL CHECK (asientos_disponibles >= 0)
);

-- Insert de 20 registro de la tabla vuelos: 
INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AA-101', 250.00, 120);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AA-102', 275.50, 95);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('LA-201', 320.75, 80);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('LA-202', 450.00, 60);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AV-301', 180.25, 150);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AV-302', 210.00, 140);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('IB-401', 980.50, 45);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('IB-402', 1025.99, 38);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('DL-501', 550.75, 70);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('DL-502', 610.00, 65);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('UA-601', 430.20, 90);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('UA-602', 475.80, 85);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('CM-701', 295.40, 110);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('CM-702', 340.60, 105);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AF-801', 1150.00, 30);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('AF-802', 1240.75, 25);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('KL-901', 890.30, 50);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('KL-902', 940.90, 48);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('BA-111', 1300.00, 3);

INSERT INTO vuelos (codigo, precio_boleto, asientos_disponibles)
VALUES ('BA-112', 1375.50, 0);

SELECT * FROM vuelos;

--Parte 1.3consultas: 
-- Alerta de Vuelo Lleno: 
SELECT * FROM vuelos WHERE asientos_disponibles < 5;

--Incremento de Tarifas
UPDATE vuelos SET precio_boleto = precio_boleto * 1.15 WHERE id = 5;
SELECT * FROM vuelos WHERE id = 5; -- Verifica que se hizo la actualizacion

-- Eliminacion de vuelos en cero o cerrados: 
DELETE FROM vuelos WHERE asientos_disponibles = 0;

