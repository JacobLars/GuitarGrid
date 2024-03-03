export type Guitar = {
  id: string;
  name: string;
  price: number;
  color: string;
  bodyType: string;
  neckType: string;
  fretboardType: string;
  pickups: string;
  frets: number;
  scale: number;
  images: Image[];
  brandName: string;
  brandLogo: string;
  rating: number;
  product_quantity: number;
};

export type Tuner = {
  id: string;
  name: string;
  price: number;
  display: string;
  design: string;
  chromatic: boolean;
  integrated_metronome: boolean;
  integrated_microphone: boolean;
  images: Image[];
  brandName: string;
  brandLogo: string;
  rating: number;
  product_quantity: number;
};

export type Product = {
  id: string;
  name: string;
  price: number;
  rating: number;
  product_quantity: number;
  images: Image[];
  brandName: string;
};

export type Image = {
  id: string;
  url: string;
  isMain: boolean;
};
