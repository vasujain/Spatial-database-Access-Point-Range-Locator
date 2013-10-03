---------------------------------------------------------------------------
-- CREATE TABLE FOR INPUT FILES --
---------------------------------------------------------------------------
CREATE TABLE building1 (buildid VARCHAR(15) PRIMARY KEY, buildname VARCHAR(50),numpoint NUMBER,points SDO_GEOMETRY);

CREATE TABLE people1(personid VARCHAR(5) PRIMARY KEY, people_location SDO_GEOMETRY);
CREATE TABLE apt1(accessid VARCHAR(10) PRIMARY KEY, radius NUMBER, apt_location SDO_GEOMETRY);
		   

---------------------------------------------------------------------------
-- UPDATE METADATA VIEW --
---------------------------------------------------------------------------
-- Update the USER_SDO_GEOM_METADATA view. This is required
-- before the Spatial index can be created. Do this only once for each
-- layer (that is, table-column combination;).

INSERT INTO USER_SDO_GEOM_METADATA(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID)
VALUES (
'apt1',
'apt_location',
SDO_DIM_ARRAY(    --820*580 grid
	SDO_DIM_ELEMENT('X', 0, 820, 1),
	SDO_DIM_ELEMENT('Y', 0, 580, 1)
	),
NULL --SRID
);

INSERT INTO USER_SDO_GEOM_METADATA(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID)
VALUES (
'people1',
'people_location',
SDO_DIM_ARRAY(    --820*580 grid
	SDO_DIM_ELEMENT('X', 0, 820, 1),
	SDO_DIM_ELEMENT('Y', 0, 580, 1)
	),
NULL --SRID
);

INSERT INTO USER_SDO_GEOM_METADATA(TABLE_NAME,COLUMN_NAME,DIMINFO,SRID)
VALUES (
'building1',
'points',
SDO_DIM_ARRAY(    --820*580 grid
	SDO_DIM_ELEMENT('X', 0, 820, 1),
	SDO_DIM_ELEMENT('Y', 0, 580, 1)
	),
NULL --SRID
);

--SDO_ORDINATES 
-------------------------------------------------------------------
-- CREATE THE SPATIAL INDEX --
-------------------------------------------------------------------
-- Preceding statement created an R-tree index.

CREATE INDEX building_spatial_idx1 ON building1(points) INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX people_spatial_idx1 ON people1(people_location) INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX apt_spatial_idx1 ON apt1(apt_location) INDEXTYPE IS MDSYS.SPATIAL_INDEX;
