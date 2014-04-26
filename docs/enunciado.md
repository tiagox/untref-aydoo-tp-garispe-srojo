Trabajo Práctico N° 1
=====================

La secretaria de turismo de la Tierra Media ha decidido crear una sistema para promocionar el turismo en su territorio. El sistema en cuestión contará con la información de las distintas atracciones de toda la Tierra Media. El sistema deberá ser capaz de sugerir visitas a partir de la ubicación de los visitantes y también de generar itinerarios a partir de la información de preferencias disponible en el perfil de los usuarios. Se espera que los usuarios puedan descargarse una aplicación móvil que les permita interactuar con el sistema y los vaya guiando en su recorrido.

Dado el alcance del sistema y la limitación de tiempo, varios equipos han sido contratados para el desarrollo de este sistema.

En el caso de su equipo, debe implementar la lógica para sugerir visitas e itinerarios respetando las siguientes especificaciones:

- Para cada atracción se cuenta con sus coordenadas globales de posicionamiento, su costo de visita, el promedio de tiempo necesario para visita, el cupo de visitantes diarios y el tipo de atracción (paisaje, de aventura, de degustación).
- Por su parte para cada usuario el sistema conoce su presupuesto, el tiempo disponible para visitas, su velocidad de traslado y el tipo de atracción preferida.
- En la generación de las sugerencias debe contemplase las promociones vigentes. Cada promoción incluye una o varias atracciones y beneficia al usuario con una reducción del costo total. Se espera que el sistema permita la definición de promociones de tres tipos diferentes:
    + Promociones porcentuales (X % de descuento en el costo total)
    + Promociones absolutas ($X por todo el paquete)
    + Promociones A x B (si el usuario compra A, B, C entonces tiene gratis D).
- Cada promoción tiene un período de vigencia.

Entregables:
------------

- Código y tests automatizados que implementar el dominio
- Diagramas de clase y de secuencia
