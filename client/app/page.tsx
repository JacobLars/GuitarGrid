"use client";
import { NavBar } from "./components/navbar/NavBar";
import { Categories } from "./components/products/Categories";
import { Header } from "./components/home/Header";
import { BrandGallery } from "./components/brands/BrandGallery";

export default function Home() {
  return (
    <div className="grid grid-cols-1">
      <Header />
      <NavBar />
      <div className="flex flex-col items-center">
        <Categories />
        <BrandGallery />
      </div>
    </div>
  );
}
