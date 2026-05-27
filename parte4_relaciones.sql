
-- Creacion de las tablas:

CREATE TABLE proyectos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dias_estimados INTEGER NOT NULL CHECK (dias_estimados > 0)
);

CREATE TABLE tecnologias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    categoria VARCHAR(30) NOT NULL
);

CREATE TABLE proyectos_tecnologias (
    id_proyecto INTEGER NOT NULL,
    id_tecnologia INTEGER NOT NULL,

    PRIMARY KEY (id_proyecto, id_tecnologia),

    FOREIGN KEY (id_proyecto) REFERENCES proyectos(id) ON DELETE CASCADE,

    FOREIGN KEY (id_tecnologia) REFERENCES tecnologias(id) ON DELETE CASCADE
);


--Insert: 


INSERT INTO proyectos (nombre, dias_estimados) VALUES
('Sistema Web', 30),
('App Movil', 45),
('API REST', 20);

INSERT INTO tecnologias (nombre, categoria) VALUES
('Java', 'Backend'),
('Spring Boot', 'Backend'),
('React', 'Frontend'),
('PostgreSQL', 'Base de Datos');


INSERT INTO proyectos_tecnologias VALUES (1, 1);
INSERT INTO proyectos_tecnologias VALUES (1, 2);
INSERT INTO proyectos_tecnologias VALUES (1, 3);
INSERT INTO proyectos_tecnologias VALUES (1, 4);

-- App Movil
INSERT INTO proyectos_tecnologias VALUES (2, 1);
INSERT INTO proyectos_tecnologias VALUES (2, 4);

-- API REST
INSERT INTO proyectos_tecnologias VALUES (3, 1);
INSERT INTO proyectos_tecnologias VALUES (3, 2);
INSERT INTO proyectos_tecnologias VALUES (3, 4);


-- Muestro tablas: 

SELECT * FROM proyectos;
SELECT * FROM tecnologias;
SELECT * FROM proyectos_tecnologias;

-- Consultas Relacionales:
-- 1 Tecnologías por Proyecto

SELECT 
    t.nombre AS tecnologia,
    t.categoria
FROM tecnologias t
JOIN proyectos_tecnologias pt ON pt.id_tecnologia = t.id
JOIN proyectos p ON p.id = pt.id_proyecto
WHERE p.nombre = 'Sistema Web';


-- 2 Proyectos por Tecnología
SELECT 
    p.nombre AS proyecto,
    p.dias_estimados
FROM proyectos p
JOIN proyectos_tecnologias pt ON pt.id_proyecto = p.id
JOIN tecnologias t ON t.id = pt.id_tecnologia
WHERE t.id = 1;

-- 3 Reporte de Uso Tecnologico
SELECT 
    t.nombre AS tecnologia,
    COUNT(pt.id_proyecto) AS total_proyectos
FROM tecnologias t
LEFT JOIN proyectos_tecnologias pt ON pt.id_tecnologia = t.id
GROUP BY t.nombre
ORDER BY total_proyectos DESC;
