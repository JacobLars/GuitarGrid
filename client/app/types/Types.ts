export type Brand = {
  id: string;
  name: string;
  logo: string;
};

export type Guitar = {
  id: string;
  name: string;
  price: number;
  color: string;
  type: string;
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
  category: string;
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
  category: string;
};

export type Amplifier = {
  id: string;
  name: string;
  price: number;
  images: Image[];
  brandName: string;
  brandLogo: string;
  rating: number;
  product_quantity: number;
  category: string;
  weight: number;
  power: number;
  channels: number;
  reverb: boolean;
  externalFxLoop: boolean;
  lineInput: boolean;
  footSwitchConnection: boolean;
  effectsProcessor: boolean;
  microphoneInput: boolean;
  batteryOperation: boolean;
};

export type Product = {
  id: string;
  name: string;
  price: number;
  rating: number;
  product_quantity: number;
  images: Image[];
  brandName: string;
  category: string;
};

export type Image = {
  id: string;
  url: string;
  isMain: boolean;
};
