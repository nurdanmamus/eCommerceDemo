PGDMP     
    
                y            hrms    13.2    13.2     ±           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ²           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ³           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ´           1262    16564    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1252';
    DROP DATABASE hrms;
                postgres    false            É            1259    16573    Employee    TABLE     ë   CREATE TABLE public."Employee" (
    "EmployeeId" integer NOT NULL,
    "Name" character varying(30) NOT NULL,
    "Surname" character varying(30) NOT NULL,
    "Tckn" character(11) NOT NULL,
    "YearOfBirth" character(4) NOT NULL
);
    DROP TABLE public."Employee";
       public         heap    postgres    false            È            1259    16568    Users    TABLE     –   CREATE TABLE public."Users" (
    "Id" integer NOT NULL,
    "Email" character varying(30) NOT NULL,
    "Password" character varying(20) NOT NULL
);
    DROP TABLE public."Users";
       public         heap    postgres    false            ®          0    16573    Employee 
   TABLE DATA           \   COPY public."Employee" ("EmployeeId", "Name", "Surname", "Tckn", "YearOfBirth") FROM stdin;
    public          postgres    false    201   —       ­          0    16568    Users 
   TABLE DATA           <   COPY public."Users" ("Id", "Email", "Password") FROM stdin;
    public          postgres    false    200   ´       )           2606    16577    Employee Employee_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT "Employee_pkey" PRIMARY KEY ("EmployeeId");
 D   ALTER TABLE ONLY public."Employee" DROP CONSTRAINT "Employee_pkey";
       public            postgres    false    201            %           2606    16584    Users uk_email 
   CONSTRAINT     N   ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT uk_email UNIQUE ("Email");
 :   ALTER TABLE ONLY public."Users" DROP CONSTRAINT uk_email;
       public            postgres    false    200            '           2606    16572    Users users_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT users_pkey PRIMARY KEY ("Id");
 <   ALTER TABLE ONLY public."Users" DROP CONSTRAINT users_pkey;
       public            postgres    false    200            *           2606    16578    Employee fk_employee_users 
   FK CONSTRAINT     Ž   ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT fk_employee_users FOREIGN KEY ("EmployeeId") REFERENCES public."Users"("Id") NOT VALID;
 F   ALTER TABLE ONLY public."Employee" DROP CONSTRAINT fk_employee_users;
       public          postgres    false    201    2855    200            ®   
   xœ‹Ñãââ Å ©      ­      xœ3äô
rqôã44261ÉãŠÑãââ 8¡‡     
