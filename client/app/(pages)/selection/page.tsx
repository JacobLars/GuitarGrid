"use client";
import { GuitarSelection } from "@/app/components/products/guitars/GuitarSelection";
import { Header } from "@/app/components/header/Header";
import { NavBar } from "@/app/components/navbar/NavBar";

export default function Selection() {
  return (
    <div className="">
      <Header />
      <NavBar />
      <GuitarSelection />
    </div>
  );
}
