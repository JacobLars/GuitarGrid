"use client";
import { NavBar } from "./components/navbar/NavBar";
import { Categories } from "./components/products/Categories";
import { Header } from "./components/home/Header";
import { BrandGallery } from "./components/brands/BrandGallery";

export default function Home() {
  return (
    <div className="">
      <Header />
      <NavBar />
      <Categories />
      <BrandGallery />
    </div>
  );
}
