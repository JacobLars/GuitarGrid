"use client";
import { NavBar } from "./components/navbar/NavBar";
import { Categories } from "./components/products/Categories";
import { Header } from "./components/home/Header";
import { BrandGallery } from "./components/brands/BrandGallery";
import { Menu } from "./components/userActions/Menu";

export default function Home() {
  return (
    <div className="grid grid-cols-1">
      <Header />
      <Menu />
      <NavBar />
      <div className="flex flex-col items-center">
        <Categories />
        <BrandGallery />
      </div>
    </div>
  );
}
