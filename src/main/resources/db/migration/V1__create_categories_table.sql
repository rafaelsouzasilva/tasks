CREATE TABLE public.categories (
    id UUID DEFAULT random_uuid() NOT NULL,
    name VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);
