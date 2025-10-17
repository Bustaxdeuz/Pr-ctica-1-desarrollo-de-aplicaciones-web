-- Eliminar base de datos si existe (opcional, para empezar limpio)
DROP DATABASE IF EXISTS practica;

-- Crear la base de datos
CREATE DATABASE practica;

-- Usar la base de datos
USE practica;

-- Crear la tabla arbol
CREATE TABLE arbol (
    id_arbol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comun VARCHAR(100) NOT NULL,
    tipo_flor VARCHAR(100),
    dureza_madera VARCHAR(50),
    altura_maxima DECIMAL(5,2),
    ruta_imagen VARCHAR(255)
);

-- Crear el usuario (si ya existe, primero elimínalo)
DROP USER IF EXISTS 'usuario_practica'@'localhost';
CREATE USER 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';

-- Otorgar TODOS los permisos sobre la base de datos practica
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';

-- Aplicar los cambios
FLUSH PRIVILEGES;

-- Insertar datos de prueba (tu código)
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_maxima, ruta_imagen) 
VALUES 
('Roble', 'Sin flor vistosa', 'Muy dura', 25.50, '/images/roble.jpg'),
('Ceiba', 'Blanca', 'Blanda', 40.00, '/images/ceiba.jpg'),
('Guanacaste', 'Naranja', 'Media', 30.00, '/images/guanacaste.jpg');

-- Verificar que todo se creó correctamente
SELECT * FROM arbol;